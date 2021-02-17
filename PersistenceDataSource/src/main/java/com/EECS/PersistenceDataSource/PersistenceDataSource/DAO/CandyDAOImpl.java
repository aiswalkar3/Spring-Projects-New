package com.EECS.PersistenceDataSource.PersistenceDataSource.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CandyDAOImpl implements CandyDAO{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final String GET_ALL_CANDY_LIST = "Select * from candy";
    private static final BeanPropertyRowMapper<CandyData> candyRowMapper = new BeanPropertyRowMapper<>(CandyData.class);

    @Override
    public List<CandyData> list()
    {
        /*Correct approach using ResultSetExtractor*/
        /*
        return jdbcTemplate.query(GET_ALL_CANDY_LIST,
                resultSet -> {
                    List<CandyData> candyList = new ArrayList<>();
                    int row = 0;

                    while(resultSet.next())
                    {
                        candyList.add(candyRowMapper.mapRow(resultSet, row));
                        row++;
                    }
                    return candyList;
                });

         */

        return jdbcTemplate.query(GET_ALL_CANDY_LIST, candyRowMapper);
    }

    private static final String INSERT_DELIVERY = "INSERT INTO candy_delivery (candy_id,delivery_id) "+
            "VALUES(:candyId, :deliveryId)";

    @Override
    public void addToDelivery(Long candyId, Long deliveryId)
    {
        jdbcTemplate.update(INSERT_DELIVERY,
                new MapSqlParameterSource()
                        .addValue("candyId", candyId)
                        .addValue("deliveryId",deliveryId)
        );

    }

    private static final String FIND_BY_DELIVERY = "SELECT * from candy_delivery cd join candy c on cd.candy_id = c.id " +
            "WHERE cd.delivery_id = :deliveryId";

    @Override
    public List<CandyData> findByDelivery(Long deliveryId)
    {
        /*Correct approach using ResultSetExtractor*/
        /*
        return jdbcTemplate.query(FIND_BY_DELIVERY,
                new MapSqlParameterSource().addValue("deliveryId",deliveryId),
                resultSet -> {
                    List<CandyData> result = new ArrayList<>();
                    int row = 0;

                    while (resultSet.next()) {
                        result.add(candyRowMapper.mapRow(resultSet, row));
                        row++;
                    }

                    return result;
                }
                );
         */
        return jdbcTemplate.query(FIND_BY_DELIVERY,
                new MapSqlParameterSource().addValue("deliveryId",deliveryId),
                candyRowMapper);

    }
}
