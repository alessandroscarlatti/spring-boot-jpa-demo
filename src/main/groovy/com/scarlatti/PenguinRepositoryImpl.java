package com.scarlatti;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 6/2/2018
 */
@Component
public class PenguinRepositoryImpl implements SillyRepo {

    private JdbcTemplate jdbcTemplate;

    public PenguinRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Penguin> asdf() {
        return jdbcTemplate.query("SELECT * FROM PENGUIN", (rs, rowNum) -> {
            Penguin penguin = new Penguin();
            penguin.setFirstName(rs.getString("FIRST_NAME"));
            penguin.setLastName(rs.getString("LAST_NAME"));
            return penguin;
        });
    }
}
