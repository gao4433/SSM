package cc.gaojie.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 数据源相关
 * @date 2022/3/16 18:37
 * @since 1.8
 */
//<context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource("classpath:jdbc.properties") //加载外部配置文件
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //Spring会将当前方法的返回值以指定名称存储到容器中
    @Bean("dataSource")
    public DataSource getDataSource() throws PropertyVetoException {
        //创建数据源实例
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置数据源连接参数
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }


}
