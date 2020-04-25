package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import modelo.Especialidad;

class EspecialidadTest {

	@Test
	void testGetTipoPorNombre() {
		assertNull(Especialidad.getTipoPorNombre("noexiste"));
		assertEquals(Especialidad.ballesta, Especialidad.getTipoPorNombre("ballesta"));
	}

}
