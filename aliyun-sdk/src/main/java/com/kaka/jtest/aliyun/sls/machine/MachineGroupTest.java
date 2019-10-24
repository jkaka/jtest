package com.kaka.jtest.aliyun.sls.machine;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.aliyun.openservices.log.common.MachineGroup;
import com.aliyun.openservices.log.exception.LogException;
import com.aliyun.openservices.log.response.CreateMachineGroupResponse;
import com.aliyun.openservices.log.response.GetMachineGroupResponse;
import com.aliyun.openservices.log.response.ListMachineGroupResponse;
import com.kaka.jtest.aliyun.sls.SlsBaseTest;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-22 09:10
 */
public class MachineGroupTest extends SlsBaseTest {
	@Test
	public void create() throws LogException {
		String ips = "[\"{\\\\\\\"cluster_name\\\\\\\":\\\\\\\"slb-us-west-1-pub-1\\\\\\\"}\"]";
		JSONArray keysArray = JSON.parseArray(ips);
		ArrayList<String> ipList = new ArrayList<String>();
		for (Object key : keysArray) {
			ipList.add(key.toString().trim());
		}

		MachineGroup machineGroup = new MachineGroup("test-group", "ip", ipList);
		CreateMachineGroupResponse createMachineGroupResponse = client.CreateMachineGroup(defaultProject, machineGroup);
		System.out.println(createMachineGroupResponse.GetAllHeaders());
	}

	@Test
	public void listMachineGroup() throws LogException {
		ListMachineGroupResponse listMachineGroupResponse = client.ListMachineGroup(defaultProject);
		System.out.println(listMachineGroupResponse.GetMachineGroups());
		System.out.println(listMachineGroupResponse.GetMachineGroups());
	}

	@Test
	public void getMachineGroup() throws LogException {
		GetMachineGroupResponse getMachineGroupResponse = client.GetMachineGroup(defaultProject, "test-group");
		MachineGroup machineGroup = getMachineGroupResponse.GetMachineGroup();
		System.out.println(machineGroup.GetMachineList());
		System.out.println(machineGroup.GetGroupName());
		System.out.println(machineGroup.GetGroupAttribute());
	}
}
