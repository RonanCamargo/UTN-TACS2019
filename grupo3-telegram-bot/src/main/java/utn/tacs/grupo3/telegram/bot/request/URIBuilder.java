package utn.tacs.grupo3.telegram.bot.request;

public class URIBuilder {
	
	private String uri;	
	
	public URIBuilder() {
		this.uri = new String();
	}
	
	public URIBuilder setBaseUri(String baseUri) {
		this.uri += (baseUri);
		return this;
	}
	
	public URIBuilder setRelativeUri(String relativeUri) {
		this.uri += relativeUri;
		return this;
	}
	
	public URIBuilder setParameter(String key, Object value) {
		this.uri = uri.replace(key, value.toString());
		return this;
	}
	
	public String build() {
		return this.uri;
	}
	
}
