package utn.tacs.grupo3.spring.converter;

public interface Converter<I, O> {
	
	O convert(I input);
}
