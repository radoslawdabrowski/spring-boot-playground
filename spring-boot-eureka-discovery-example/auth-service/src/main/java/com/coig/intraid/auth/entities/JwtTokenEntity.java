package com.coig.intraid.auth.entities;

import com.coig.intraid.auth.components.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;

import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "iid_tokens")
@Entity
@Slf4j
public class JwtTokenEntity extends Id {

    @Column(name = "value")
    private String value;

    @Column(name = "expired")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expired;

    @ManyToOne
    private UserEntity user;

    @Transient
    public JwtTokenEntity build(UserEntity userEntity) {
        setExpired(new Date());
        setValue(md5( RandomStringUtils.random(256) + "fasejfoaisejfoasiejfoaisejf"));
        setUser(userEntity);
        return this;
    }

    @Transient
    private static String md5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xfff));
            }
            s = sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            log.error("MD5 not found");
        }
        return s;
    }

}
