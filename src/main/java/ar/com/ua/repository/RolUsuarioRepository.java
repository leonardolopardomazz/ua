package ar.com.ua.repository;

public interface RolUsuarioRepository<Entity> {
	void customSave(Entity rolesUsuarios);
	void customDelete(Entity rolesUsuarios);
}
