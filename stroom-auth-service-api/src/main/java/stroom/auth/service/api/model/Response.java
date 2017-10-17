/*
 * Stroom Auth API
 * Various APIs for interacting with authentication, users, and tokens.
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package stroom.auth.service.api.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Response
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-16T10:38:22.749+01:00")
public class Response {
  @SerializedName("context")
  private Map<String, Object> context = new HashMap<String, Object>();

  @SerializedName("cancelled")
  private Boolean cancelled = null;

  @SerializedName("done")
  private Boolean done = null;

  public Response context(Map<String, Object> context) {
    this.context = context;
    return this;
  }

  public Response putContextItem(String key, Object contextItem) {
    this.context.put(key, contextItem);
    return this;
  }

   /**
   * Get context
   * @return context
  **/
  @ApiModelProperty(example = "null", value = "")
  public Map<String, Object> getContext() {
    return context;
  }

  public void setContext(Map<String, Object> context) {
    this.context = context;
  }

  public Response cancelled(Boolean cancelled) {
    this.cancelled = cancelled;
    return this;
  }

   /**
   * Get cancelled
   * @return cancelled
  **/
  @ApiModelProperty(example = "null", value = "")
  public Boolean getCancelled() {
    return cancelled;
  }

  public void setCancelled(Boolean cancelled) {
    this.cancelled = cancelled;
  }

  public Response done(Boolean done) {
    this.done = done;
    return this;
  }

   /**
   * Get done
   * @return done
  **/
  @ApiModelProperty(example = "null", value = "")
  public Boolean getDone() {
    return done;
  }

  public void setDone(Boolean done) {
    this.done = done;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Response response = (Response) o;
    return Objects.equals(this.context, response.context) &&
        Objects.equals(this.cancelled, response.cancelled) &&
        Objects.equals(this.done, response.done);
  }

  @Override
  public int hashCode() {
    return Objects.hash(context, cancelled, done);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response {\n");
    
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("    cancelled: ").append(toIndentedString(cancelled)).append("\n");
    sb.append("    done: ").append(toIndentedString(done)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

