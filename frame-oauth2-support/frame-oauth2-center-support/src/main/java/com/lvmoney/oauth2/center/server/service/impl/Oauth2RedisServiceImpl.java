package com.lvmoney.oauth2.center.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.lvmoney.common.exceptions.BusinessException;
import com.lvmoney.common.exceptions.CommonException;
import com.lvmoney.oauth2.center.server.ro.AuthorizationCodeRo;
import com.lvmoney.oauth2.center.server.vo.resp.AuthorizationRespVo;
import com.lvmoney.oauth2.center.server.vo.AuthorizationVo;
import com.lvmoney.redis.service.BaseRedisService;
import com.lvmoney.oauth2.center.server.constant.Oauth2ServerConstant;
import com.lvmoney.oauth2.center.server.ro.Oauth2ClientRo;
import com.lvmoney.oauth2.center.server.vo.OauthClient;
import com.lvmoney.oauth2.center.server.vo.UserInfo;
import com.lvmoney.oauth2.center.server.ro.Oauth2ClientDetailRo;
import com.lvmoney.oauth2.center.server.ro.Oauth2UserRo;
import com.lvmoney.oauth2.center.server.service.Oauth2RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2019年1月18日 上午11:28:35
 */
@Service
public class Oauth2RedisServiceImpl implements Oauth2RedisService {

    @Autowired
    BaseRedisService baseRedisService;

    @Override
    public void userDetails2Redis(Oauth2UserRo oauth2UserRo) {
        baseRedisService.addMap(Oauth2ServerConstant.REDIS_FRAME_USER_DETAILS_NAME, oauth2UserRo.getData(), oauth2UserRo.getExpire());
    }

    public UserInfo getOauth2UserVo(String username) {
        Object obj = baseRedisService.getValueByMapKey(Oauth2ServerConstant.REDIS_FRAME_USER_DETAILS_NAME, username);
        try {
            UserInfo userInfo = JSON.parseObject(obj.toString(), new TypeReference<UserInfo>() {
            });
            return userInfo;
        } catch (Exception e) {
            throw new BusinessException(CommonException.Proxy.OAUTH2_USER_DETAIL_NO_EXIST);

        }

    }

    @Override
    public BaseClientDetails getClientDetailsByClientId(String clientId) {
        Object obj = baseRedisService.getValueByMapKey(Oauth2ServerConstant.REDIS_FRAME_CLIENT_DETAILS_NAME, clientId);
        try {
            BaseClientDetails baseClientDetails = JSON.parseObject(obj.toString(), new TypeReference<BaseClientDetails>() {
            });
            return baseClientDetails;
        } catch (Exception e) {
            throw new BusinessException(CommonException.Proxy.OAUTH2_CLIENT_DETAIL_NO_EXIST);
        }
    }

    @Override
    public void clientDetails2Redis(Oauth2ClientDetailRo oauth2ClientDetailRo) {
        baseRedisService.addMap(Oauth2ServerConstant.REDIS_FRAME_CLIENT_DETAILS_NAME, oauth2ClientDetailRo.getData(), oauth2ClientDetailRo.getExpire());
    }

    @Override
    public void client2Redis(Oauth2ClientRo oauth2ClientRo) {
        baseRedisService.addMap(Oauth2ServerConstant.REDIS_FRAME_CLIENT_NAME, oauth2ClientRo.getData(), oauth2ClientRo.getExpire());
    }

    @Override
    public OauthClient getClientByClientId(String clientId) {
        Object obj = baseRedisService.getValueByMapKey(Oauth2ServerConstant.REDIS_FRAME_CLIENT_NAME, clientId);
        try {
            OauthClient oauthClient = JSON.parseObject(obj.toString(), new TypeReference<OauthClient>() {
            });
            return oauthClient;
        } catch (Exception e) {
            throw new BusinessException(CommonException.Proxy.OAUTH2_CLIENT_DETAIL_NO_EXIST);
        }
    }

    @Override
    public void authorizationCode2Redis(AuthorizationCodeRo authorizationCodeRo) {
        baseRedisService.addMap(Oauth2ServerConstant.REDIS_FRAME_AUTHENTICATION_CODE_NAME, authorizationCodeRo.getData(), authorizationCodeRo.getExpire());
    }

    @Override
    public void deleteAuthorizationCode(String code) {
        baseRedisService.deleteValueByMapKey(Oauth2ServerConstant.REDIS_FRAME_AUTHENTICATION_CODE_NAME, code);
    }

    @Override
    public AuthorizationVo getAuthorizationCodeByCode(String code) {
        Object obj = baseRedisService.getValueByMapKey(Oauth2ServerConstant.REDIS_FRAME_AUTHENTICATION_CODE_NAME, code);
        try {
            AuthorizationRespVo authorizationRespVo = JSON.parseObject(obj.toString(), new TypeReference<AuthorizationRespVo>() {
            });
            AuthorizationVo authorizationVo = authorizationRespVo2AuthorizationVo(authorizationRespVo);
            return authorizationVo;
        } catch (Exception e) {
            throw new BusinessException(CommonException.Proxy.OAUTH2_AUTHENTICATION_NO_EXIST);
        }

    }

    private AuthorizationVo authorizationRespVo2AuthorizationVo(AuthorizationRespVo authorizationRespVo) {
        AuthorizationVo authorizationVo = new AuthorizationVo();
        com.lvmoney.oauth2.center.server.vo.Oauth2Request fOauth2Request = authorizationRespVo.getOAuth2Request();
        OAuth2Request oAuth2Request = new OAuth2Request(fOauth2Request.
                getRequestParameters(), fOauth2Request.getClientId(), null,
                fOauth2Request.isApproved(), fOauth2Request.getScope(),
                null, fOauth2Request.getRedirectUri(), fOauth2Request.
                getResponseTypes(), null);
        authorizationVo.setOAuth2Request(oAuth2Request);
        com.lvmoney.oauth2.center.server.vo.Authentication fAuthorization = authorizationRespVo.getAuthentication();
        Authentication authentication = new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return fAuthorization.getDetails();
            }

            @Override
            public Object getPrincipal() {
                return fAuthorization.getPrincipal();
            }

            @Override
            public boolean isAuthenticated() {
                return fAuthorization.isAuthenticated();
            }

            @Override
            public void setAuthenticated(boolean b) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return fAuthorization.getName();
            }
        };
        authorizationVo.setAuthentication(authentication);
        return authorizationVo;
    }

}