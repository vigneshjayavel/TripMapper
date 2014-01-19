package pojo.distance;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BingDistance {
	public abstract String getAuthenticationResultCode() ;

	@JsonProperty("authenticationResultCode")
    public abstract void setAuthenticationResultCode(String authenticationResultCode);

	@JsonProperty("brandLogoUri")
    public abstract String getBrandLogoUri() ;

	@JsonProperty("copyright")
    public abstract String getCopyright() ;


	@JsonProperty("resourceSets")
    public abstract List<?> getResourceSets() ;


	@JsonProperty("statusCode")
    public abstract Integer getStatusCode() ;


	@JsonProperty("statusDescription")
    public abstract String getStatusDescription() ;


	@JsonProperty("traceId")
    public abstract String getTraceId() ;


	@JsonAnyGetter
    public abstract Map<String, Object> getAdditionalProperties() ;
}
