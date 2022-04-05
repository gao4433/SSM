package cc.gaojie.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gaojie  gao4433@qq.com
 * @Description  定义转换器类实现 Converter 接口
 * @date 2022/4/5 16:24
 * @since 1.8
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        //将日期字符串转换成日期对象，返回
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(source);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
