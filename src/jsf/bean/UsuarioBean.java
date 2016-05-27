package jsf.bean;

import java.util.Date;
import java.util.List;

import model.jpa.Usuario;
import dao.impl.UsuarioDAOImpl;

public class UsuarioBean {
	public String usuario,clave;
	public Date f_registro;
	public Integer estado;
	
	public UsuarioDAOImpl usudaoimpl=new UsuarioDAOImpl();
	
	private List<Usuario>listaUsuarios;
	private int tamano_lista;
	private boolean accion_modificar;
	
	Usuario obj=new Usuario();
	
	public boolean accion_agrega()
	{
		accion_modificar=false;
		return accion_modificar;
	}
	public boolean accion_modifica()
	{
		accion_modificar=true;
		return accion_modificar;
	}
	
	public String validar_login() throws Exception
	{
		String validacion="ERROR";
		Usuario objusu=new Usuario();
		objusu.setUsuario(getUsuario());
		objusu.setClave(getClave());
		obj=usudaoimpl.validarUsuario(objusu);
		if (obj!=null && obj.getUsuario()!=null)
		{
			validacion="EXITO";
			setUsuario(obj.getUsuario());
			setClave(obj.getClave());
		}
		return validacion;
	}
	public void agregarUsuario() throws Exception
	{
		Usuario objusu=new Usuario();
		objusu.setUsuario(getUsuario());
		objusu.setClave(getClave());
		objusu.setEstado(getEstado());
		objusu.setF_registro(getF_registro());
		usudaoimpl.agregarUsuario(objusu);
	}
	public void modificarUsuario() throws Exception
	{
		Usuario objusu=new Usuario();
		objusu.setUsuario(getUsuario());
		objusu.setClave(getClave());
		objusu.setEstado(getEstado());
		objusu.setF_registro(getF_registro());
		usudaoimpl.modificarUsuario(objusu);
	}
	public void buscarlistaUsuarios() throws Exception
	{
		Usuario objusu=new Usuario();
		objusu.setUsuario(getUsuario());
		objusu=usudaoimpl.buscarUsuario(objusu);
		listaUsuarios=usudaoimpl.buscarListaUsuario(objusu);
		tamano_lista=listaUsuarios.size();
	}
	
	public void limpiar()
	{
		setUsuario(null);
		setClave(null);
		setF_registro(null);
		setEstado(-1);
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Date getF_registro() {
		return f_registro;
	}
	public void setF_registro(Date f_registro) {
		this.f_registro = f_registro;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public int getTamano_lista() {
		return tamano_lista;
	}
	public void setTamano_lista(int tamano_lista) {
		this.tamano_lista = tamano_lista;
	}

	public boolean isAccion_modificar() {
		return accion_modificar;
	}

	public void setAccion_modificar(boolean accion_modificar) {
		this.accion_modificar = accion_modificar;
	}
	
	
}
