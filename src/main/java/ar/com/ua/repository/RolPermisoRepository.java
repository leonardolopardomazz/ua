package ar.com.ua.repository;

public interface RolPermisoRepository<Entity> {
	void customSave(Entity rolPermiso);
	void customDelete(Entity rolPermiso);
}
