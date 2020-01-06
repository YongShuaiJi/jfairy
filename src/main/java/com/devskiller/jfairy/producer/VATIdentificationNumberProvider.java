/*
 * Copyright (c) 2013 Codearte and authors
 */

package com.devskiller.jfairy.producer;

import com.google.inject.Provider;

/**
 * VAT identification number (VATIN)
 *
 * @author mariuszs
 * @since 02.11.13.
 */
public interface VATIdentificationNumberProvider extends Provider<String> {

	String get();
}
