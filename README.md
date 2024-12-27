# Api VentaXpress 🚀

API RESTful desarrollada en Java con Spring Boot para gestión de ventas. Diseñada para ser escalable y eficiente.

## 🛠️ Tecnologías

- Java 17
- Spring Boot
- MySQL 8.x
- Maven 3.8.x
- Lombok
- Spring DevTools

## ⚙️ Instalación

1. **Clonar repositorio**
   ```bash
   git clone https://github.com/BrayanReynoso/api-ventaxpress.git
   cd api-ventaxpress
   ```

2. **Configurar MySQL**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ventaxpress
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Compilar y ejecutar**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## 🔗 Endpoints

### Proveedores (Supplier)
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET    | /api/supplier/ | Listar proveedores |
| POST   | /api/supplier/ | Crear proveedor |
| DELETE | /api/supplier/status/{id} | Cambiar estado |

### Ventas (Sale)
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET    | /api/sale/ | Listar ventas |
| POST   | /api/sale/ | Crear venta |

### Productos (Product)
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET    | /api/product/ | Listar productos |
| POST   | /api/product/ | Crear producto |
| PUT    | /api/product/ | Actualizar producto |
| DELETE | /api/product/status/{id} | Cambiar estado |

### Categorías (Category)
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET    | /api/category/ | Listar categorías |
| POST   | /api/category/ | Crear categoría |
| PUT    | /api/category/ | Actualizar categoría |
| DELETE | /api/category/status/{id} | Cambiar estado |

### Marcas (Brand)
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET    | /api/brand/ | Listar marcas |
| POST   | /api/brand/ | Crear marca |
| PUT    | /api/brand/ | Actualizar marca |
| DELETE | /api/brand/status/{id} | Cambiar estado |

## 📁 Estructura

```
api-ventaxpress/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.mx.ventaxpress/
│   │   │       ├── controller/     # Controladores REST
│   │   │       ├── model           # Clases de modelo
│   │   │       ├── repository      # Repositorios JPA
│   │   │       └── service         # Lógica de negocio
│   │   └── resources
│   │       ├── application.properties  # Configuración de la aplicación
│   └── test/
└── pom.xml
```

## 🤝 Contribuciones

¡Contribuciones bienvenidas! Abre un issue o pull request.
