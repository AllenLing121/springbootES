package com.ling.dao;

import com.ling.entity.Commodity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Lian on 03/07/2019.
 */
@Repository
public interface CommodityRepository extends ElasticsearchRepository<Commodity, String> {

}
