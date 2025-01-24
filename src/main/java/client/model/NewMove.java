/*
 * Robot Wars API
 * Eine Api für das Spiel Robot Wars
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.client.model.Align;
import io.swagger.client.model.MovementType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Objects;
/**
 * NewMove
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2025-01-23T08:39:22.725219046Z[GMT]")

public class NewMove {
  @SerializedName("playerId")
  private String playerId = null;

  @SerializedName("movementType")
  private MovementType movementType = null;

  @SerializedName("mapIndex")
  private BigDecimal mapIndex = null;

  @SerializedName("align")
  private Align align = null;

  public NewMove playerId(String playerId) {
    this.playerId = playerId;
    return this;
  }

   /**
   * Der Spieler , der seinen Roboter bewegt oder Aktionen durchführt
   * @return playerId
  **/
  @Schema(example = "1234", required = true, description = "Der Spieler , der seinen Roboter bewegt oder Aktionen durchführt")
  public String getPlayerId() {
    return playerId;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  public NewMove movementType(MovementType movementType) {
    this.movementType = movementType;
    return this;
  }

   /**
   * Get movementType
   * @return movementType
  **/
  @Schema(required = true, description = "")
  public MovementType getMovementType() {
    return movementType;
  }

  public void setMovementType(MovementType movementType) {
    this.movementType = movementType;
  }

  public NewMove mapIndex(BigDecimal mapIndex) {
    this.mapIndex = mapIndex;
    return this;
  }

   /**
   * Postion im Map Array
   * @return mapIndex
  **/
  @Schema(example = "1", required = true, description = "Postion im Map Array")
  public BigDecimal getMapIndex() {
    return mapIndex;
  }

  public void setMapIndex(BigDecimal mapIndex) {
    this.mapIndex = mapIndex;
  }

  public NewMove align(Align align) {
    this.align = align;
    return this;
  }

   /**
   * Get align
   * @return align
  **/
  @Schema(required = true, description = "")
  public Align getAlign() {
    return align;
  }

  public void setAlign(Align align) {
    this.align = align;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewMove newMove = (NewMove) o;
    return Objects.equals(this.playerId, newMove.playerId) &&
        Objects.equals(this.movementType, newMove.movementType) &&
        Objects.equals(this.mapIndex, newMove.mapIndex) &&
        Objects.equals(this.align, newMove.align);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playerId, movementType, mapIndex, align);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewMove {\n");
    
    sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
    sb.append("    movementType: ").append(toIndentedString(movementType)).append("\n");
    sb.append("    mapIndex: ").append(toIndentedString(mapIndex)).append("\n");
    sb.append("    align: ").append(toIndentedString(align)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
