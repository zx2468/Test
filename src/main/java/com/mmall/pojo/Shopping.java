package com.mmall.pojo;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
 * @author admin
 * @date 2018/8/2 10:39
 */
@Getter
@Setter
public class Shopping {

        private Integer id;

        private Integer userId;

        private String receiverName;

        private String receiverPhone;

        private String receiverMobile;

        private String receiverProvince;

        private String receiverCity;

        private String receiverDistrict;

        private String receiverAddress;

        private String receiverZip;

        private Date createTime;

        private Date updateTime;

        public Shopping(Integer id, Integer userId, String receiverName, String receiverPhone, String receiverMobile, String receiverProvince, String receiverCity, String receiverDistrict, String receiverAddress, String receiverZip, Date createTime, Date updateTime) {
            this.id = id;
            this.userId = userId;
            this.receiverName = receiverName;
            this.receiverPhone = receiverPhone;
            this.receiverMobile = receiverMobile;
            this.receiverProvince = receiverProvince;
            this.receiverCity = receiverCity;
            this.receiverDistrict = receiverDistrict;
            this.receiverAddress = receiverAddress;
            this.receiverZip = receiverZip;
            this.createTime = createTime;
            this.updateTime = updateTime;
        }

        public Shopping() {
            super();
        }

}
