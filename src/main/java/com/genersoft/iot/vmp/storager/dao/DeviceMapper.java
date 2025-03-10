package com.genersoft.iot.vmp.storager.dao;

import com.genersoft.iot.vmp.gb28181.bean.Device;
import com.genersoft.iot.vmp.vmanager.bean.ResourceBaceInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用于存储设备信息
 */
@Mapper
@Repository
public interface DeviceMapper {

    @Select("SELECT " +
            "deviceId, " +
            "coalesce(custom_name, name) as name, " +
            "password, " +
            "manufacturer, " +
            "model, " +
            "firmware, " +
            "transport," +
            "streamMode," +
            "ip," +
            "sdpIp," +
            "localIp," +
            "port," +
            "hostAddress," +
            "expires," +
            "registerTime," +
            "keepaliveTime," +
            "createTime," +
            "updateTime," +
            "charset," +
            "subscribeCycleForCatalog," +
            "subscribeCycleForMobilePosition," +
            "mobilePositionSubmissionInterval," +
            "subscribeCycleForAlarm," +
            "ssrcCheck," +
            "asMessageChannel," +
            "geoCoordSys," +
            "treeType," +
            "online," +
            "mediaServerId," +
            "(SELECT count(0) FROM device_channel WHERE deviceId=device.deviceId) as channelCount "+
            " FROM device WHERE deviceId = #{deviceId}")
    Device getDeviceByDeviceId(String deviceId);

    @Insert("INSERT INTO device (" +
                "deviceId, " +
                "name, " +
                "manufacturer, " +
                "model, " +
                "firmware, " +
                "transport," +
                "streamMode," +
                "ip," +
                "sdpIp," +
                "localIp," +
                "port," +
                "hostAddress," +
                "expires," +
                "registerTime," +
                "keepaliveTime," +
                "keepaliveIntervalTime," +
                "createTime," +
                "updateTime," +
                "charset," +
                "subscribeCycleForCatalog," +
                "subscribeCycleForMobilePosition," +
                "mobilePositionSubmissionInterval," +
                "subscribeCycleForAlarm," +
                "ssrcCheck," +
                "asMessageChannel," +
                "geoCoordSys," +
                "treeType," +
                "online" +
            ") VALUES (" +
                "#{deviceId}," +
                "#{name}," +
                "#{manufacturer}," +
                "#{model}," +
                "#{firmware}," +
                "#{transport}," +
                "#{streamMode}," +
                "#{ip}," +
                "#{sdpIp}," +
                "#{localIp}," +
                "#{port}," +
                "#{hostAddress}," +
                "#{expires}," +
                "#{registerTime}," +
                "#{keepaliveTime}," +
                "#{keepaliveIntervalTime}," +
                "#{createTime}," +
                "#{updateTime}," +
                "#{charset}," +
                "#{subscribeCycleForCatalog}," +
                "#{subscribeCycleForMobilePosition}," +
                "#{mobilePositionSubmissionInterval}," +
                "#{subscribeCycleForAlarm}," +
                "#{ssrcCheck}," +
                "#{asMessageChannel}," +
                "#{geoCoordSys}," +
                "#{treeType}," +
                "#{online}" +
            ")")
    int add(Device device);

    @Update(value = {" <script>" +
                "UPDATE device " +
                "SET updateTime=#{updateTime}" +
                "<if test=\"name != null\">, name=#{name}</if>" +
                "<if test=\"manufacturer != null\">, manufacturer=#{manufacturer}</if>" +
                "<if test=\"model != null\">, model=#{model}</if>" +
                "<if test=\"firmware != null\">, firmware=#{firmware}</if>" +
                "<if test=\"transport != null\">, transport=#{transport}</if>" +
                "<if test=\"ip != null\">, ip=#{ip}</if>" +
                "<if test=\"localIp != null\">, localIp=#{localIp}</if>" +
                "<if test=\"port != null\">, port=#{port}</if>" +
                "<if test=\"hostAddress != null\">, hostAddress=#{hostAddress}</if>" +
                "<if test=\"online != null\">, online=#{online}</if>" +
                "<if test=\"registerTime != null\">, registerTime=#{registerTime}</if>" +
                "<if test=\"keepaliveTime != null\">, keepaliveTime=#{keepaliveTime}</if>" +
                "<if test=\"keepaliveIntervalTime != null\">, keepaliveIntervalTime=#{keepaliveIntervalTime}</if>" +
                "<if test=\"expires != null\">, expires=#{expires}</if>" +
                "WHERE deviceId=#{deviceId}"+
            " </script>"})
    int update(Device device);

    @Select(
            " <script>" +
            "SELECT " +
            "deviceId, " +
            "coalesce(custom_name, name) as name, " +
            "password, " +
            "manufacturer, " +
            "model, " +
            "firmware, " +
            "transport," +
            "streamMode," +
            "ip," +
            "sdpIp," +
            "localIp," +
            "port," +
            "hostAddress," +
            "expires," +
            "registerTime," +
            "keepaliveTime," +
            "createTime," +
            "updateTime," +
            "charset," +
            "subscribeCycleForCatalog," +
            "subscribeCycleForMobilePosition," +
            "mobilePositionSubmissionInterval," +
            "subscribeCycleForAlarm," +
            "ssrcCheck," +
            "asMessageChannel," +
            "geoCoordSys," +
            "treeType," +
            "online," +
            "mediaServerId," +
            "(SELECT count(0) FROM device_channel WHERE deviceId=de.deviceId) as channelCount  FROM device de" +
            "<if test=\"online != null\"> where online=${online}</if>"+
            " </script>"
    )
    List<Device> getDevices(Boolean online);

    @Delete("DELETE FROM device WHERE deviceId=#{deviceId}")
    int del(String deviceId);

    @Select("SELECT " +
            "deviceId, " +
            "coalesce(custom_name, name) as name, " +
            "password, " +
            "manufacturer, " +
            "model, " +
            "firmware, " +
            "transport," +
            "streamMode," +
            "ip," +
            "sdpIp," +
            "localIp," +
            "port," +
            "hostAddress," +
            "expires," +
            "registerTime," +
            "keepaliveTime," +
            "createTime," +
            "updateTime," +
            "charset," +
            "subscribeCycleForCatalog," +
            "subscribeCycleForMobilePosition," +
            "mobilePositionSubmissionInterval," +
            "subscribeCycleForAlarm," +
            "ssrcCheck," +
            "asMessageChannel," +
            "geoCoordSys," +
            "treeType," +
            "online " +
            " FROM device WHERE online = 1")
    List<Device> getOnlineDevices();
    @Select("SELECT " +
            "deviceId, " +
            "coalesce(custom_name, name) as name, " +
            "password, " +
            "manufacturer, " +
            "model, " +
            "firmware, " +
            "transport," +
            "streamMode," +
            "ip," +
            "sdpIp," +
            "localIp," +
            "port," +
            "hostAddress," +
            "expires," +
            "registerTime," +
            "keepaliveTime," +
            "createTime," +
            "updateTime," +
            "charset," +
            "subscribeCycleForCatalog," +
            "subscribeCycleForMobilePosition," +
            "mobilePositionSubmissionInterval," +
            "subscribeCycleForAlarm," +
            "ssrcCheck," +
            "asMessageChannel," +
            "geoCoordSys," +
            "treeType," +
            "online" +
            " FROM device WHERE ip = #{host} AND port=#{port}")
    Device getDeviceByHostAndPort(String host, int port);

    @Update(value = {" <script>" +
            "UPDATE device " +
            "SET updateTime=#{updateTime}" +
            "<if test=\"name != null\">, custom_name=#{name}</if>" +
            "<if test=\"password != null\">, password=#{password}</if>" +
            "<if test=\"streamMode != null\">, streamMode=#{streamMode}</if>" +
            "<if test=\"ip != null\">, ip=#{ip}</if>" +
            "<if test=\"sdpIp != null\">, sdpIp=#{sdpIp}</if>" +
            "<if test=\"port != null\">, port=#{port}</if>" +
            "<if test=\"charset != null\">, charset=#{charset}</if>" +
            "<if test=\"subscribeCycleForCatalog != null\">, subscribeCycleForCatalog=#{subscribeCycleForCatalog}</if>" +
            "<if test=\"subscribeCycleForMobilePosition != null\">, subscribeCycleForMobilePosition=#{subscribeCycleForMobilePosition}</if>" +
            "<if test=\"mobilePositionSubmissionInterval != null\">, mobilePositionSubmissionInterval=#{mobilePositionSubmissionInterval}</if>" +
            "<if test=\"subscribeCycleForAlarm != null\">, subscribeCycleForAlarm=#{subscribeCycleForAlarm}</if>" +
            "<if test=\"ssrcCheck != null\">, ssrcCheck=#{ssrcCheck}</if>" +
            "<if test=\"asMessageChannel != null\">, asMessageChannel=#{asMessageChannel}</if>" +
            "<if test=\"geoCoordSys != null\">, geoCoordSys=#{geoCoordSys}</if>" +
            "<if test=\"treeType != null\">, treeType=#{treeType}</if>" +
            "<if test=\"mediaServerId != null\">, mediaServerId=#{mediaServerId}</if>" +
            "WHERE deviceId=#{deviceId}"+
            " </script>"})
    void updateCustom(Device device);

    @Insert("INSERT INTO device (" +
            "deviceId, " +
            "custom_name, " +
            "password, " +
            "sdpIp, " +
            "createTime," +
            "updateTime," +
            "charset," +
            "ssrcCheck," +
            "asMessageChannel," +
            "geoCoordSys," +
            "treeType," +
            "online," +
            "mediaServerId" +
            ") VALUES (" +
            "#{deviceId}," +
            "#{name}," +
            "#{password}," +
            "#{sdpIp}," +
            "#{createTime}," +
            "#{updateTime}," +
            "#{charset}," +
            "#{ssrcCheck}," +
            "#{asMessageChannel}," +
            "#{geoCoordSys}," +
            "#{treeType}," +
            "#{online}," +
            "#{mediaServerId}" +
            ")")
    void addCustomDevice(Device device);

    @Select("select count(1) as total, sum(online) as online from device")
    ResourceBaceInfo getOverview();

    @Select("select * from device")
    List<Device> getAll();

    @Select("select * from device where  asMessageChannel = 1")
    List<Device> queryDeviceWithAsMessageChannel();
}
