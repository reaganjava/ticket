package com.pj.ebcenter.manager.local.ftp.service;

import java.util.List;

import com.pj.ebcenter.manager.local.vo.LocalEquipmentVo;

public interface ILocalFtpService {

	public void getVoucherDataFromTtp(String ftpAbsultePath);

	public void saveLocalEquipmentVo(List<LocalEquipmentVo> data);
}
