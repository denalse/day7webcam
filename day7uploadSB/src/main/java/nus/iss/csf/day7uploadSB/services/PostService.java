package nus.iss.csf.day7uploadSB.services;

import java.sql.ResultSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import nus.iss.csf.day7uploadSB.model.Post;

@Service
public class PostService {
    
    private static final String SQL_GET_UPLOAD = "select * from post where post_id = ?";

    @Autowired
    private JdbcTemplate temp;

    public Optional<Post> getPost(Integer postId) {
        return temp.query(SQL_GET_UPLOAD,
            (ResultSet rs) -> {
                if (!rs.next())
                    return Optional.empty();
                return Optional.of(Post.create(rs));
            }, postId);
    }

}
