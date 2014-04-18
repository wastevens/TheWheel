package com.dstevens.utilities;

import static com.dstevens.collections.Lists.list;

import java.util.List;

import com.dstevens.structures.messages.Message;

public abstract class Validator<E> {

    public abstract List<Message> validate(E e);
    
    public final Validator<E> and(Validator<E> validator) {
        return new AndValidator<>(this, validator);
    }
    
    private static class AndValidator<E> extends Validator<E> {
        
        private Validator<E> validator;
        private Validator<E> andValidator;

        public List<Message> validate(E e) {
            List<Message> validationMessages = list();
            validationMessages.addAll(validator.validate(e));
            validationMessages.addAll(andValidator.validate(e));
            return validationMessages;
        }
        
        private AndValidator(Validator<E> validator, Validator<E> andValidator) {
            this.validator = validator;
            this.andValidator = andValidator;
        }
        
    }
    
}
