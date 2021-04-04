package com.stu.otsea.content.service;

import com.stu.otsea.dao.ResourceDao;
import com.stu.otsea.entity.po.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/3/11 16:38
 * @Description:
 */
@Service
public class ResourceService {
    @Autowired
    private ResourceDao resourceDao;

    public Resource getResourceById(int id) {
        return resourceDao.selectById(id);
    }

    public int insertImage(String link) {
        Resource resource = new Resource();
        resource.setInformation("");
        resource.setResourcePath(link);
        resource.setResourceType((short) 0);
        resourceDao.insert(resource);
        return resource.getResourceId();
    }
}
