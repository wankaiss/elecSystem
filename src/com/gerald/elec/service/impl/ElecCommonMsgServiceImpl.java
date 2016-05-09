package com.gerald.elec.service.impl;

import com.gerald.elec.dao.IElecCommonMsgContentDao;
import com.gerald.elec.dao.IElecCommonMsgDao;
import com.gerald.elec.domain.ElecCommonMsg;
import com.gerald.elec.domain.ElecCommonMsgContent;
import com.gerald.elec.service.IElecCommonMsgService;
import com.gerald.elec.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 3/28/2016.
 */
@Service(value = IElecCommonMsgService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecCommonMsgServiceImpl implements IElecCommonMsgService {

    @Resource(name = IElecCommonMsgDao.SERVICE_NAME)
    private IElecCommonMsgDao iElecCommonMsgDao;

    @Resource(name = IElecCommonMsgContentDao.SERVICE_NAME)
    private IElecCommonMsgContentDao elecCommonMsgContentDao;

    @Override
    public ElecCommonMsg find() {

        List<ElecCommonMsg> list = iElecCommonMsgDao.findCollectionByCondiitionNoPage("",null,null);

        ElecCommonMsg commonMsg = null;
        if(list!=null && list.size()>0){
            commonMsg = list.get(0);
            /**********************************************begin**********************************************************/
            //��ȡ��������
            //��������Ϊ������������ʾ˳���������У���ѯվ���������������
            String stationCondition = " and o.type=?";
            Object [] stationParams = {"1"};
            Map<String, String> stationOrderby = new LinkedHashMap<String, String>();
            stationOrderby.put("o.orderby", "asc");
            List<ElecCommonMsgContent> stationList = elecCommonMsgContentDao.findCollectionByCondiitionNoPage(stationCondition, stationParams, stationOrderby);
            //��ȡ���ص����ݣ�ƴװ֮��
            String stationContent = "";
            if(stationList!=null && stationList.size()>0){
                for(ElecCommonMsgContent elecCommonMsgContent:stationList){
                    String content = elecCommonMsgContent.getContent();
                    stationContent += content;
                }
            }
            //�����ݸ�ֵ��ҳ������ԣ�վ�����������
            commonMsg.setStationRun(stationContent);
            /**********************************************************************************/
            //��������Ϊ������������ʾ˳���������У���ѯվ���������������
            String devCondition = " and o.type=?";
            Object [] devParams = {"2"};
            Map<String, String> devOrderby = new LinkedHashMap<String, String>();
            devOrderby.put("o.orderby", "asc");
            List<ElecCommonMsgContent> devList = elecCommonMsgContentDao.findCollectionByCondiitionNoPage(devCondition, devParams, devOrderby);
            //��ȡ���ص����ݣ�ƴװ֮��
            String devContent = "";
            if(devList!=null && devList.size()>0){
                for(ElecCommonMsgContent elecCommonMsgContent:devList){
                    String content = elecCommonMsgContent.getContent();
                    devContent += content;
                }
            }
            //�����ݸ�ֵ��ҳ������ԣ��豸���������
            commonMsg.setDevRun(devContent);
            /**********************************************end**********************************************************/
        }
        return commonMsg;
    }

    /*@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false)
    public void update(ElecCommonMsg elecCommonMsg) {
        List<ElecCommonMsg> list = iElecCommonMsgDao.findCollectionByCondiitionNoPage("", null, null);

        if (list != null && list.size() > 0) {
            ElecCommonMsg elecCommonMsg1 = list.get(0);
            elecCommonMsg1.setCreateDate(new Date());
            elecCommonMsg1.setDevRun(elecCommonMsg.getDevRun());
            elecCommonMsg1.setStationRun(elecCommonMsg.getStationRun());
            //iElecCommonMsgDao.save(elecCommonMsg1);
        } else {
            elecCommonMsg.setCreateDate(new Date());
            iElecCommonMsgDao.save(elecCommonMsg);
        }
    }*/

    /**
     * @return
     */
    public ElecCommonMsg findCommonMsg() {
        List<ElecCommonMsg> list = iElecCommonMsgDao.findCollectionByCondiitionNoPage("", null, null);
        ElecCommonMsg commonMsg = null;
        if(list!=null && list.size()>0){
            commonMsg = list.get(0);
            /**********************************************begin**********************************************************/
            //��ȡ��������
            //��������Ϊ������������ʾ˳���������У���ѯվ���������������
            String stationCondition = " and o.type=?";
            Object [] stationParams = {"1"};
            Map<String, String> stationOrderby = new LinkedHashMap<String, String>();
            stationOrderby.put("o.orderby", "asc");
            List<ElecCommonMsgContent> stationList = elecCommonMsgContentDao.findCollectionByCondiitionNoPage(stationCondition, stationParams, stationOrderby);
            //��ȡ���ص����ݣ�ƴװ֮��
            String stationContent = "";
            if(stationList!=null && stationList.size()>0){
                for(ElecCommonMsgContent elecCommonMsgContent:stationList){
                    String content = elecCommonMsgContent.getContent();
                    stationContent += content;
                }
            }
            //�����ݸ�ֵ��ҳ������ԣ�վ�����������
            commonMsg.setStationRun(stationContent);
            /**********************************************************************************/
            //��������Ϊ������������ʾ˳���������У���ѯվ���������������
            String devCondition = " and o.type=?";
            Object [] devParams = {"2"};
            Map<String, String> devOrderby = new LinkedHashMap<String, String>();
            devOrderby.put("o.orderby", "asc");
            List<ElecCommonMsgContent> devList = elecCommonMsgContentDao.findCollectionByCondiitionNoPage(devCondition, devParams, devOrderby);
            //��ȡ���ص����ݣ�ƴװ֮��
            String devContent = "";
            if(devList!=null && devList.size()>0){
                for(ElecCommonMsgContent elecCommonMsgContent:devList){
                    String content = elecCommonMsgContent.getContent();
                    devContent += content;
                }
            }
            //�����ݸ�ֵ��ҳ������ԣ��豸���������
            commonMsg.setDevRun(devContent);
            /**********************************************end**********************************************************/
        }
        return commonMsg;
    }


    /**
     * @param elecCommonMsg
     */
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void update(ElecCommonMsg elecCommonMsg) {
        /**********************************************begin**********************************************************/
        //���浽���ݱ���
        //ɾ��֮ǰ������
        List<ElecCommonMsgContent> contentList = elecCommonMsgContentDao.findCollectionByCondiitionNoPage("", null, null);
        elecCommonMsgContentDao.deleteObjectByColletcion(contentList);
        //��ҳ���ȡվ������������豸�������������վ��������������豸���������������
        String stationRun = elecCommonMsg.getStationRun();
        String devRun = elecCommonMsg.getDevRun();
        //����StirngUtil�ķ������ָ��ַ���
        List<String> stationList = StringUtil.getContentByList(stationRun, 50);
        if(stationList!=null && stationList.size()>0){
            for(int i=0;i<stationList.size();i++){
                ElecCommonMsgContent elecCommonMsgContent = new ElecCommonMsgContent();
                elecCommonMsgContent.setType("1");//1��ʾվ���������
                elecCommonMsgContent.setContent(stationList.get(i));
                elecCommonMsgContent.setOrderby(i+1);
                elecCommonMsgContentDao.save(elecCommonMsgContent);
            }
        }
        List<String> devList = StringUtil.getContentByList(devRun, 50);
        if(devList!=null && devList.size()>0){
            for(int i=0;i<devList.size();i++){
                ElecCommonMsgContent elecCommonMsgContent = new ElecCommonMsgContent();
                elecCommonMsgContent.setType("2");//2��ʾ�豸�������
                elecCommonMsgContent.setContent(devList.get(i));
                elecCommonMsgContent.setOrderby(i+1);
                elecCommonMsgContentDao.save(elecCommonMsgContent);
            }
        }
        /**********************************************end**********************************************************/


        //��ѯ���м�ر���ȡ���м�ر�����ݣ�����List<ElecCommonMsg> list��ʹ��list��Ϊ�ж����ݿ����Ƿ��������
        List<ElecCommonMsg> list = iElecCommonMsgDao.findCollectionByCondiitionNoPage("", null, null);
        //���list!=null:���ݱ���д������ݣ���ȡҳ�洫�ݵ�2����������֯PO����ִ�и��£�update��
        if(list!=null && list.size()>0){
            //����һ����ɾ���ٴ���
            //����������֯PO����ִ��update
            ElecCommonMsg commonMsg = list.get(0);
            commonMsg.setStationRun("1");//1��ʾվ���������
            commonMsg.setDevRun("2");//2��ʾ�豸�������
            commonMsg.setCreateDate(new Date());
        }
        //���list==null:���ݱ���в��������ݣ���ȡҳ�洫�ݵ�2����������֯PO����ִ��������save��
        else{
            ElecCommonMsg commonMsg = new ElecCommonMsg();
            commonMsg.setCreateDate(new Date());
            commonMsg.setStationRun("1");//1��ʾվ���������
            commonMsg.setDevRun("2");//2��ʾ�豸�������
            iElecCommonMsgDao.save(commonMsg);
        }


    }
}
