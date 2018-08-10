package com.zhongtai.dao;

import com.zhongtai.pojo.Organization;
import java.util.List;
import java.util.Map;

public interface OrganizationMapper {

    public List<Organization> selectOrganization(Map<String, Object> params);
    public void insertOrganization(Organization organization);
    public void deleteOrganization(Integer id);
    public void updateOrganization(Organization organization);
}
