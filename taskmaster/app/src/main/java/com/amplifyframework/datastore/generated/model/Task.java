package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Task type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Tasks", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Task implements Model {
  public static final QueryField ID = field("Task", "id");
  public static final QueryField TASK_TITLE = field("Task", "taskTitle");
  public static final QueryField TASK_BODY = field("Task", "taskBody");
  public static final QueryField TASK_STATE = field("Task", "taskState");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String taskTitle;
  private final @ModelField(targetType="String", isRequired = true) String taskBody;
  private final @ModelField(targetType="TaskStateEnum", isRequired = true) TaskStateEnum taskState;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getTaskTitle() {
      return taskTitle;
  }
  
  public String getTaskBody() {
      return taskBody;
  }
  
  public TaskStateEnum getTaskState() {
      return taskState;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Task(String id, String taskTitle, String taskBody, TaskStateEnum taskState) {
    this.id = id;
    this.taskTitle = taskTitle;
    this.taskBody = taskBody;
    this.taskState = taskState;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Task task = (Task) obj;
      return ObjectsCompat.equals(getId(), task.getId()) &&
              ObjectsCompat.equals(getTaskTitle(), task.getTaskTitle()) &&
              ObjectsCompat.equals(getTaskBody(), task.getTaskBody()) &&
              ObjectsCompat.equals(getTaskState(), task.getTaskState()) &&
              ObjectsCompat.equals(getCreatedAt(), task.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), task.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getTaskTitle())
      .append(getTaskBody())
      .append(getTaskState())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Task {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("taskTitle=" + String.valueOf(getTaskTitle()) + ", ")
      .append("taskBody=" + String.valueOf(getTaskBody()) + ", ")
      .append("taskState=" + String.valueOf(getTaskState()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static TaskTitleStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Task justId(String id) {
    return new Task(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      taskTitle,
      taskBody,
      taskState);
  }
  public interface TaskTitleStep {
    TaskBodyStep taskTitle(String taskTitle);
  }
  

  public interface TaskBodyStep {
    TaskStateStep taskBody(String taskBody);
  }
  

  public interface TaskStateStep {
    BuildStep taskState(TaskStateEnum taskState);
  }
  

  public interface BuildStep {
    Task build();
    BuildStep id(String id);
  }
  

  public static class Builder implements TaskTitleStep, TaskBodyStep, TaskStateStep, BuildStep {
    private String id;
    private String taskTitle;
    private String taskBody;
    private TaskStateEnum taskState;
    @Override
     public Task build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Task(
          id,
          taskTitle,
          taskBody,
          taskState);
    }
    
    @Override
     public TaskBodyStep taskTitle(String taskTitle) {
        Objects.requireNonNull(taskTitle);
        this.taskTitle = taskTitle;
        return this;
    }
    
    @Override
     public TaskStateStep taskBody(String taskBody) {
        Objects.requireNonNull(taskBody);
        this.taskBody = taskBody;
        return this;
    }
    
    @Override
     public BuildStep taskState(TaskStateEnum taskState) {
        Objects.requireNonNull(taskState);
        this.taskState = taskState;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String taskTitle, String taskBody, TaskStateEnum taskState) {
      super.id(id);
      super.taskTitle(taskTitle)
        .taskBody(taskBody)
        .taskState(taskState);
    }
    
    @Override
     public CopyOfBuilder taskTitle(String taskTitle) {
      return (CopyOfBuilder) super.taskTitle(taskTitle);
    }
    
    @Override
     public CopyOfBuilder taskBody(String taskBody) {
      return (CopyOfBuilder) super.taskBody(taskBody);
    }
    
    @Override
     public CopyOfBuilder taskState(TaskStateEnum taskState) {
      return (CopyOfBuilder) super.taskState(taskState);
    }
  }
  
}
