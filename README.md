# TPO Programación II - Grupo 2

Repositorio del trabajo práctico obligatorio de la materia **Algoritmos y Estructura de Datos II (UADE)**.

## 📄 Consignas
[Ver consignas del TPO](docs/TPO.pdf)

---

## 🌿 Flujo de trabajo con branches

Cada integrante trabaja **en su propia branch personal** (una por integrante).  
La branch `main` está **protegida** y **no se puede pushear directamente**:  
solo se actualiza a través de **Pull Requests** que pasen los tests automáticos.

| Integrante | Branch | Contenido asignado |
|-------------|---------|--------------------|
| Simón Aguirre | `simon` | Ejercicios 1–3 |
| Celeste González | `celeste` | Ejercicios 4-5 |
| Micaela Pasman | `micaela` | Ejercicios 6–7 |
| Dana Egochine | `dana` | Ejercicios 8–9 |
| Ezequiel Mónaco | `ezequiel` | Ejercicios 10–12 |
| Valentin Troitiño | `valentin` | Ejercicios 13–15 |

---

## ⚙️ Cómo trabajar correctamente

### 🧱 1. Clonar el proyecto
```bash
git clone git@github.com:<tu-usuario>/tpo-progra2-grupo2.git
cd tpo-progra2-grupo2
```

### 🌿 2. Cambiarte a tu branch personal
```bash
git checkout simon
```

Verificá con:
```bash
git branch
```
Debe aparecer con un `*` tu nombre.

### 🧑‍💻 3. Hacer tus cambios
Modificá o agregá código **solo dentro de tus ejercicios asignados**.

### 🧪 4. Probar localmente los tests
```bash
mvn clean test
```
Si ves `BUILD SUCCESS`, ✅ todo está bien.

### 🚀 5. Subir tus cambios
Antes de subir tus cambios, **actualizá tu branch con la última versión de `main`** para evitar conflictos:

```bash
git pull origin main
```

Si Git te pide resolver conflictos, hacelo **en tu branch**, nunca en `main`.

Luego, confirmá y subí tus cambios:

```bash
git add .
git commit -m "Resuelvo ejercicios asignados"
git push
```
### 🔄 6. Crear un Pull Request (PR)
Desde GitHub:  
1. **Compare & pull request**  
2. Base: `main` ← Compare: `simon`  
3. Enviar el PR con descripción breve.

### 🧪 7. Tests automáticos (GitHub Actions)
- ✅ Si pasa, se puede mergear
- ❌ Si falla, el merge queda bloqueado

### 🔒 8. Merge a main
**No se puede pushear directo a main.**