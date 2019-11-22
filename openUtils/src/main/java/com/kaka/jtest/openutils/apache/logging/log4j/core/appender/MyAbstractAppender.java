package com.kaka.jtest.openutils.apache.logging.log4j.core.appender;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.util.Booleans;

import java.io.Serializable;

/**
 * Plugin中的name就是自定义的节点名称
 * 如name=MyAbstractAppender     即对应<MyAbstractAppender />
 *
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-11-22 11:31
 */
@Plugin(name = "MyAbstractAppender", category = "Core", elementType = "appender", printObject = true)
public class MyAbstractAppender extends AbstractAppender {
    protected MyAbstractAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions, Property[] properties) {
        super(name, filter, layout, ignoreExceptions, properties);
    }

    @Override
    public void append(LogEvent event) {
        System.out.println("自定义输出日志:" + event.getMessage().getFormattedMessage());
    }

    @PluginFactory
    public static MyAbstractAppender createAppender(
            @PluginAttribute("name") final String name,
            @PluginElement("Filter") final Filter filter,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginConfiguration final Configuration config,
            @PluginAttribute("ignoreExceptions") final String ignore,
            @PluginAttribute("myAttribute") final String myAttribute) {
        System.out.println("创建自定义Appender,myAttribute参数：" + myAttribute);
        boolean ignoreExceptions = Booleans.parseBoolean(ignore, true);
        return new MyAbstractAppender(name, filter, layout, ignoreExceptions, Property.EMPTY_ARRAY);
    }
}
