package com.jstarcraft.nlp.lucene.ik;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.ResourceLoader;
import org.apache.lucene.analysis.util.ResourceLoaderAware;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.dic.Dictionary;

/**
 * @author <a href="magese@live.cn">Magese</a>
 */
public class IkTokenizerFactory extends TokenizerFactory implements ResourceLoaderAware, UpdateThread.UpdateJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(IkTokenizerFactory.class);

    private boolean useSmart;

    private ResourceLoader loader;

    private long lastUpdateTime = -1L;

    private String conf = "ik.conf";

    public IkTokenizerFactory(Map<String, String> configuration) {
        super(configuration);
        String useSmartArg = configuration.get("useSmart");
        String confArg = configuration.get("conf");
        this.setUseSmart(Boolean.parseBoolean(useSmartArg));
        this.setConf(confArg);
    }

    @Override
    public Tokenizer create(AttributeFactory factory) {
        return new IkTokenizer(factory, useSmart());
    }

    /**
     * 通知方法，用于获取工厂使用的资源文件路径等信息，实现与{@link ResourceLoaderAware#inform(ResourceLoader)}
     * 当该方法被调用时，将当前实例注册到更新任务中
     *
     * @param resourceLoader 类路径资源加载实例
     * @throws IOException IO读写异常
     */
    @Override
    public void inform(ResourceLoader resourceLoader) throws IOException {
        System.out.println(String.format("IKTokenizerFactory " + this.hashCode() + " inform conf: %s", getConf()));
        this.loader = resourceLoader;
        update();
        if ((getConf() != null) && (!getConf().trim().isEmpty())) {
            UpdateThread.getInstance().register(this);
        }
    }

    /**
     * 实现更新任务接口的更新方法
     *
     * @throws IOException 读取文件异常
     */
    @Override
    public void update() throws IOException {
        // 默认UTF-8解码
        CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);

        // 获取ik.conf配置文件信息
        Properties p = canUpdate();
        if (p != null) {
            // 获取词典表名称集合
            List<String> dicPaths = SplitFileNames(p.getProperty("files"));
            // 获取词典文件的IO流
            List<Reader> inputStreamReaderList = new ArrayList<>();
            for (String path : dicPaths) {
                if ((path != null) && (!path.isEmpty())) {
                    Reader isr = new InputStreamReader(loader.openResource(path), decoder);
                    inputStreamReaderList.add(isr);
                }
            }
            // 如果IO流集合不为空则执行加载词典
            if (!inputStreamReaderList.isEmpty())
                Dictionary.reloadDic(inputStreamReaderList);
        }
    }

    /**
     * 检查是否要更新
     */
    private Properties canUpdate() {
        try {
            if (getConf() == null)
                return null;
            Properties p = new Properties();
            InputStream confStream = this.loader.openResource(getConf()); // 获取配置文件流
            p.load(confStream); // 读取配置文件
            confStream.close(); // 关闭文件流
            String lastupdate = p.getProperty("lastupdate", "0"); // 获取最后更新数字
            Long t = new Long(lastupdate);

            if (t > this.lastUpdateTime) { // 如果最后更新的数字大于上次记录的最后更新数字
                this.lastUpdateTime = t; // 将最后更新数字替换为当次的数字
                String paths = p.getProperty("files"); // 获取词典文件名
                if ((paths == null) || (paths.trim().isEmpty()))
                    return null;
                System.out.println("loading " + getConf() + " files success.");
                return p;
            }
            this.lastUpdateTime = t;
            return null;
        } catch (Exception e) {
            System.err.println("parsing " + getConf() + " NullPointerException!!!" + Arrays.toString(e.getStackTrace()));
        }
        return null;
    }

    /**
     * 对多个文件名进行切割
     *
     * @param fileNames 多个文件名
     * @return 文件名集合
     */
    private static List<String> SplitFileNames(String fileNames) {
        if (fileNames == null) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        Collections.addAll(result, fileNames.split("[,\\s]+"));
        return result;
    }

    /* getter & setter */
    private boolean useSmart() {
        return useSmart;
    }

    private void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    private String getConf() {
        return conf;
    }

    private void setConf(String conf) {
        this.conf = conf;
    }

}
