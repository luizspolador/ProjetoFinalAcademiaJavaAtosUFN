package br.com.academia.web.validator;

import java.time.LocalDate;

import br.com.academia.domain.Amostra;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AmostraValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("supports: " + Amostra.class.equals(clazz));
		return Amostra.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		System.out.println("validate: true");
		
		Amostra a = (Amostra) object;
		
		LocalDate coleta = a.getDataColeta();
		
		if (a.getDataColeta() != null && a.getDataFim() != null) {
			if (a.getDataFim().isBefore(coleta)) {
				errors.rejectValue("dataFim", "PosteriorDataColeta.amostra.dataFim");
			}
		}
	}

}
