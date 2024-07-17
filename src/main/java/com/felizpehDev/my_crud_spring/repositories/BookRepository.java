package com.felizpehDev.my_crud_spring.repositories;

import com.felizpehDev.my_crud_spring.model.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository// el Repository es la clase que se encarga de interactuar con la base de datos
public class BookRepository {

    private final BookMapper bookMapper = new BookMapper();
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insert;
    private final String table = "books";

    public BookRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                          DataSource dataSource) {
        this.jdbcTemplate = namedParameterJdbcTemplate;
        this.insert = new SimpleJdbcInsert(dataSource)
                            .withTableName(table)
                            .usingGeneratedKeyColumns("id");
    }

    public List<Book> getAllBooks() {
        String sql = "select * from " + table; ;
        return jdbcTemplate.query(sql, bookMapper);
    }

    public long createBook(Book newBook) {
        return insert.executeAndReturnKey(
                new MapSqlParameterSource("name", newBook.name)
        ).longValue();
    }

    private static class BookMapper  implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String title = rs.getString("name");
            return new Book(id, title);
        }
    }


}
