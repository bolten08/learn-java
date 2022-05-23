//package com.learn.java.dto.todo;
//
//import com.learn.java.entity.TodoEntity;
//
//public class TodoDto {
//    private Long id;
//    private String title;
//    private Boolean completed;
//
//    public static TodoDto toDto(TodoEntity entity) {
//        TodoDto todo = new TodoDto();
//        todo.setId(entity.getId());
//        todo.setTitle(entity.getTitle());
//        todo.setCompleted(entity.getCompleted());
//        return todo;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Boolean getCompleted() {
//        return completed;
//    }
//
//    public void setCompleted(Boolean completed) {
//        this.completed = completed;
//    }
//}
