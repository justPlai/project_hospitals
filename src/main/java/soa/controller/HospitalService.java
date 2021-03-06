package soa.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import soa.dao.HospitalDAO;
import soa.model.Doctor;
import soa.model.Hospital;
import soa.response.CommonResponse;
import soa.response.HospitalResponse;
import soa.responsebyid.HospitalIdResponse;

@Path("/services")
public class HospitalService {

	HospitalDAO hospitalDAO = new HospitalDAO();

	@GET
	@Path("/hospitals")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() throws JsonGenerationException, JsonMappingException, IOException {

		// return hospitalDAO.getAllHospital();

		HospitalResponse responsePojo = new HospitalResponse();
		responsePojo.setStatus("200");
		responsePojo.setMsg("ok");
		// ObjectMapper a = new ObjectMapper();

		// String s = a.writeValueAsString(hospitalDAO.getAllHospital());
		responsePojo.setResult(hospitalDAO.getAllHospital());
		return Response.status(200).entity(responsePojo).build();
	}

	@GET
	@Path("/hospitals/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHospitalById(@PathParam("id") int id) {
		Hospital h = hospitalDAO.findByID(id);
		if (h == null) {
			return Response.status(401).entity(" Invalid Hospital id").build();
		} else {
			HospitalIdResponse responsePojo = new HospitalIdResponse();
			responsePojo.setStatus("200");
			responsePojo.setMsg("ok");
			responsePojo.setResult(hospitalDAO.findByID(id));
			return Response.status(200).entity(responsePojo).build();
		}
	}

	@POST
	@Path("/hospitals")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createHospital(Hospital Hos) throws IOException {

		if (Hos.getHospitalLocation() == null) {
			return Response.status(400).entity(" please provide Location").build();
		} else if (Hos.getHospitalName() == null) {
			return Response.status(400).entity(" please provide Name").build();
		} else if (Hos.getHospitalPhonenumber() == null) {
			return Response.status(400).entity(" please provide Phonenumber").build();
		} else {
			boolean i = hospitalDAO.addHospital(Hos);
			if (i == true) {
				// CommonResponse responsePojo2 = new CommonResponse();
				// responsePojo2.setStatus("201");
				// responsePojo2.setMsg("ok");
				// responsePojo2.setResult("create successfully");

				// return Response.status(201).entity(responsePojo2).build();
				return Response.status(201).entity(" create successfully").build();
			} else
				return Response.status(400).entity(" create fail").build();
		}
	}

	@PUT
	@Path("/hospitals")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateHospital(Hospital Hos) throws JsonGenerationException, JsonMappingException, IOException {
		// Hospital h = hospitalDAO.findByID(Hos.getHospitalId());
		Hospital h = new Hospital();
		if (Hos.getHospitalId() == null) {
			return Response.status(401).entity(" Invalid Hospital id").build();
		} else {
			h = hospitalDAO.findByID(Hos.getHospitalId());
		}
		if (Hos.getHospitalLocation() == null) {
			Hos.setHospitalLocation(h.getHospitalLocation());
		}
		if (Hos.getHospitalName() == null) {
			Hos.setHospitalName(h.getHospitalName());
		}
		if (Hos.getHospitalPhonenumber() == null) {
			Hos.setHospitalPhonenumber(h.getHospitalPhonenumber());
		}
		boolean i = hospitalDAO.updateHospital(Hos);
		if (i == true) {
			// CommonResponse responsePojo = new CommonResponse();
			// responsePojo.setStatus("200");
			// responsePojo.setMsg("ok");
			// responsePojo.setResult("update successfully");
			return Response.status(200).entity("update successfully").build();
		} else
			return Response.status(400).entity(" update fail").build();
	}

//	@PUT
//	@Path("/hospitals/{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response updateHospitalByid(@PathParam("id") int id, Hospital Hos)
//			throws JsonGenerationException, JsonMappingException, IOException {
//		Hospital h = hospitalDAO.findByID(id);
//		if (h == null) {
//			return Response.status(401).entity(" Invalid Hospital id").build();
//		} else {
//			Hos.setHospitalId(id);
//			boolean i = hospitalDAO.updateHospital(Hos);
//			if (i == true)
//				return Response.status(200).entity(" update successfully").build();
//			else
//				return Response.status(200).entity(" update fail").build();
//		}
//
//	}

	@DELETE
	@Path("/hospitals/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteHospital(@PathParam("id") int id)
			throws JsonGenerationException, JsonMappingException, IOException {
		Hospital h = hospitalDAO.findByID(id);
//		Hospital h2 = hospitalDAO.findByID(id);
		if (h == null) {
			return Response.status(401).entity(" Invalid Hospital id").build();
		} else {
			boolean i = hospitalDAO.deleteById(id);
			if (i == true) {

				// CommonResponse responsePojo = new CommonResponse();
				// responsePojo.setStatus("200");
				// responsePojo.setMsg("ok");
				// responsePojo.setResult("delete successfully");
				// return Response.status(200).entity(responsePojo).build();
				return Response.status(200).entity(" delete successfully").build();
			} else
				return Response.status(400).entity(" delete fail").build();
		}

	}

}
