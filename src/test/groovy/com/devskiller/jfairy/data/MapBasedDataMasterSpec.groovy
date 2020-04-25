package com.devskiller.jfairy.data

import com.devskiller.jfairy.producer.BaseProducer
import com.devskiller.jfairy.producer.RandomGenerator
import com.devskiller.jfairy.producer.net.IPNumberProducer
import org.apache.commons.validator.routines.InetAddressValidator

class MapBasedDataMasterSpec {

	private InetAddressValidator ipValidator = InetAddressValidator.getInstance()

	private IPNumberProducer ipNumber = new IPNumberProducer(new BaseProducer(new RandomGenerator()))
}
