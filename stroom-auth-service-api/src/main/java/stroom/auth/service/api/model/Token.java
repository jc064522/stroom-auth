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

/**
 * Token
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-12-08T08:24:32.610Z")
public class Token {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("user_email")
  private String userEmail = null;

  @SerializedName("token_type")
  private String tokenType = null;

  @SerializedName("token")
  private String token = null;

  @SerializedName("expires_on")
  private String expiresOn = null;

  @SerializedName("issued_on")
  private String issuedOn = null;

  @SerializedName("issued_by_user")
  private String issuedByUser = null;

  @SerializedName("enabled")
  private Boolean enabled = null;

  @SerializedName("updated_on")
  private String updatedOn = null;

  @SerializedName("updated_by_user")
  private String updatedByUser = null;

  public Token id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Token userEmail(String userEmail) {
    this.userEmail = userEmail;
    return this;
  }

   /**
   * Get userEmail
   * @return userEmail
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public Token tokenType(String tokenType) {
    this.tokenType = tokenType;
    return this;
  }

   /**
   * Get tokenType
   * @return tokenType
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  public Token token(String token) {
    this.token = token;
    return this;
  }

   /**
   * Get token
   * @return token
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Token expiresOn(String expiresOn) {
    this.expiresOn = expiresOn;
    return this;
  }

   /**
   * Get expiresOn
   * @return expiresOn
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getExpiresOn() {
    return expiresOn;
  }

  public void setExpiresOn(String expiresOn) {
    this.expiresOn = expiresOn;
  }

  public Token issuedOn(String issuedOn) {
    this.issuedOn = issuedOn;
    return this;
  }

   /**
   * Get issuedOn
   * @return issuedOn
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getIssuedOn() {
    return issuedOn;
  }

  public void setIssuedOn(String issuedOn) {
    this.issuedOn = issuedOn;
  }

  public Token issuedByUser(String issuedByUser) {
    this.issuedByUser = issuedByUser;
    return this;
  }

   /**
   * Get issuedByUser
   * @return issuedByUser
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getIssuedByUser() {
    return issuedByUser;
  }

  public void setIssuedByUser(String issuedByUser) {
    this.issuedByUser = issuedByUser;
  }

  public Token enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

   /**
   * Get enabled
   * @return enabled
  **/
  @ApiModelProperty(example = "null", value = "")
  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public Token updatedOn(String updatedOn) {
    this.updatedOn = updatedOn;
    return this;
  }

   /**
   * Get updatedOn
   * @return updatedOn
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(String updatedOn) {
    this.updatedOn = updatedOn;
  }

  public Token updatedByUser(String updatedByUser) {
    this.updatedByUser = updatedByUser;
    return this;
  }

   /**
   * Get updatedByUser
   * @return updatedByUser
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getUpdatedByUser() {
    return updatedByUser;
  }

  public void setUpdatedByUser(String updatedByUser) {
    this.updatedByUser = updatedByUser;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Token token = (Token) o;
    return Objects.equals(this.id, token.id) &&
        Objects.equals(this.userEmail, token.userEmail) &&
        Objects.equals(this.tokenType, token.tokenType) &&
        Objects.equals(this.token, token.token) &&
        Objects.equals(this.expiresOn, token.expiresOn) &&
        Objects.equals(this.issuedOn, token.issuedOn) &&
        Objects.equals(this.issuedByUser, token.issuedByUser) &&
        Objects.equals(this.enabled, token.enabled) &&
        Objects.equals(this.updatedOn, token.updatedOn) &&
        Objects.equals(this.updatedByUser, token.updatedByUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userEmail, tokenType, token, expiresOn, issuedOn, issuedByUser, enabled, updatedOn, updatedByUser);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Token {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userEmail: ").append(toIndentedString(userEmail)).append("\n");
    sb.append("    tokenType: ").append(toIndentedString(tokenType)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    expiresOn: ").append(toIndentedString(expiresOn)).append("\n");
    sb.append("    issuedOn: ").append(toIndentedString(issuedOn)).append("\n");
    sb.append("    issuedByUser: ").append(toIndentedString(issuedByUser)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    updatedOn: ").append(toIndentedString(updatedOn)).append("\n");
    sb.append("    updatedByUser: ").append(toIndentedString(updatedByUser)).append("\n");
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

