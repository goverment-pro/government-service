/**
* @Copyright ®2018 Sinosoft Co. Ltd. All rights reserved.
* 项目名称 : 中科软互联网中间平台
* 创建日期 : 2018年9月7日
* @Title: GateWayCorsFilter.java
* @Package com.sinosoft.icp.filter
* @author sunyufei
* @version V1.0
*/
package com.sinosoft.fgw.listmanage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

/**
 * <p> zuul跨域配置类 </p>
 * @author 孙宇飞
 * @author 佟明键
 * @date 2018年9月7日
 *
 */

@Component
@Configuration
public class GateWayCorsFilter {
	@Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许客户端传输的header *代表不做限制
        corsConfiguration.addAllowedHeader("*");
        // 允许客户端的源IP或域名 *代表不做限制
        corsConfiguration.addAllowedOrigin("*");
        // 允许客户端请求的方式GET/POST等 *代表不做限制
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        // 暴露返回头 Content-Disposition 给客户端 用以客户端获取文件名
        corsConfiguration.setExposedHeaders(Collections.singletonList("Content-Disposition"));
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}
