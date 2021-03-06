package com.neusoft.mpc.web;

import com.neusoft.mpc.utils.HttpRequestUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author siss
 * @date 202/07/06
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    /**
     * 首页
     * @param request
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView index(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();

        mv.addObject("name", "weather home");
        mv.setViewName("city-weather");
        return mv;
    }

    /**
     * 根据城市代码获取当前城市温度
     * @param cityCode
     * @return
     */
    @RequestMapping(value = "/queryCityWeather", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String queryCityWeather(@RequestParam(value = "cityCode") String cityCode){
        String url = "http://t.weather.sojson.com/api/weather/city/" + cityCode;
        String weatherRes = HttpRequestUtil.sendGet(url);

        return weatherRes;
    }
}
