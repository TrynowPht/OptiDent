package com.acme.blogging.controller;

import com.acme.blogging.model.Post;
import com.acme.blogging.resource.PostResource;
import com.acme.blogging.resource.SavePostResource;
import com.acme.blogging.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "posts", description = "the Posts API")
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PostService postService;

    @Operation(summary = "Get Posts", description = "Get All Posts by Pages", tags = { "posts" })
    @GetMapping("/posts")
    public Page<PostResource> getAllPosts(
            @Parameter(description="Pageable Parameter")
            Pageable pageable) {
        Page<Post> postsPage = postService.getAllPosts(pageable);
        List<PostResource> resources = postsPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Post by Id", description = "Get a Posts by specifying Id", tags = { "posts" })
    @GetMapping("/posts/{id}")
    public PostResource getPostById(
            @Parameter(description="Post Id")
            @PathVariable(name = "id") Long postId) {
        return convertToResource(postService.getPostById(postId));
    }

    @PostMapping("/posts")
    public PostResource createPost(@Valid @RequestBody SavePostResource resource)  {
        Post post = convertToEntity(resource);
        return convertToResource(postService.createPost(post));
    }

    @PutMapping("/posts/{id}")
    public PostResource updatePost(@PathVariable(name = "id") Long postId, @Valid @RequestBody SavePostResource resource) {
        Post post = convertToEntity(resource);
        return convertToResource(postService.updatePost(postId, post));
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(name = "id") Long postId) {
        return postService.deletePost(postId);
    }

    @GetMapping("/tags/{tagId}/posts")
    public Page<PostResource> getAllPostsByTagId(@PathVariable(name = "tagId") Long tagId, Pageable pageable) {
        Page<Post> postsPage = postService.getAllPostsByTagId(tagId, pageable);
        List<PostResource> resources = postsPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @PostMapping("/posts/{postId}/tags/{tagId}")
    public PostResource assignPostTag(@PathVariable(name = "postId") Long postId,
                              @PathVariable(name = "tagId") Long tagId) {
        return convertToResource(postService.assignPostTag(postId, tagId));
    }

    @DeleteMapping("/posts/{postId}/tags/{tagId}")
    public PostResource unassignPostTag(@PathVariable(name = "postId") Long postId,
                                @PathVariable(name = "tagId") Long tagId) {

        return convertToResource(postService.unassignPostTag(postId, tagId));
    }

    private Post convertToEntity(SavePostResource resource) {
        return mapper.map(resource, Post.class);
    }

    private PostResource convertToResource(Post entity) {
        return mapper.map(entity, PostResource.class);
    }

}
