package com.lvmoney.oauth2.center.server.service.impl;

import com.lvmoney.common.exceptions.BusinessException;
import com.lvmoney.common.exceptions.CommonException;
import com.lvmoney.oauth2.center.server.vo.UserInfo;
import com.lvmoney.oauth2.center.server.ro.Oauth2UserRo;
import com.lvmoney.oauth2.center.server.service.Oauth2RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2019年1月16日 下午1:30:40
 */
@Service
public class RedisUserDetailsServiceImpl implements UserDetailsService {
    private final static Logger logger = LoggerFactory.getLogger(RedisUserDetailsServiceImpl.class);

    @Autowired
    Oauth2RedisService oauth2RedisService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        //  这个地方通过username从redisz中获取正确的用户信息，包括密码和权限等。
//        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
//        grantedAuthorityList.add(new FrameGrantedAuthority("MY_ROLE1", "MY_MENU1"));
//        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
//        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        return new User(username, "{noop}123456", grantedAuthorityList);

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_SUPER"));

        Map<String, UserInfo> data = new HashMap<String, UserInfo>();
        Long userid = 1l;
        String userName = "zhangsan";
        String password = "$2a$10$gcrWom7ubcRaVD1.6ZIrIeJP0mtPLH5J9V/.8Qth59lZ4B/5HMq96";
        boolean enabled = true;

        UserInfo oauth2UserVo = new UserInfo(userid, userName, password,
                enabled, true, true, enabled, grantedAuthorityList);
        data.put(username, oauth2UserVo);
        Oauth2UserRo oauth2UserRo = new Oauth2UserRo();
        oauth2UserRo.setExpire(18000l);
        oauth2UserRo.setData(data);
        oauth2RedisService.userDetails2Redis(oauth2UserRo);
        try {
            UserInfo userInfo = oauth2RedisService.getOauth2UserVo(username);
            if (userInfo == null) {
                throw new BusinessException(CommonException.Proxy.OAUTH2_USER_DETAIL_NO_EXIST);
            }
            return userInfo;
        } catch (Exception e) {
            logger.error("从redis中获得oauth2user的信息报错:{}", e.getMessage());
            throw new BusinessException(CommonException.Proxy.OAUTH2_USER_DETAIL_ERROR);
        }
    }
}
