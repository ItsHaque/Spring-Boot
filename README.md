## Git setup — new project, step by step

1. **Initialize:**

        git init
        


2. **Create `.gitignore`** (avoid PowerShell `echo >`, it writes UTF-16 with a BOM and silently breaks matching):
```powershell
   [System.IO.File]::WriteAllLines("$PWD\.gitignore", @(".idea/", "out/", "target/", "*.class"), [System.Text.UTF8Encoding]::new($false))
```

3. **Verify:**

        type .gitignore


4. **First commit:**

        git add .
        git commit -m "Initial commit"


5. **Create the remote on GitHub** — New repository → do **not** check "Add README/.gitignore/license" → Create. Copy the real HTTPS URL.

6. **Link and push:**

         git remote add origin <real-url>
         git branch -M main
         git push -u origin main


7. **Confirm:**

        git remote -v
        git status
        git log --oneline


**Gotchas:**
- PowerShell `echo`/`>` encoding breaks `.gitignore` silently — use `WriteAllLines` above.
- Double-check the URL in `remote add` is real, not a placeholder or stray command.


## HTTP

- Client (browser/app) sends a **request**, server sends back a **response**. Server never pushes data unprompted.
- **Request:** method (`GET` = fetch, `POST` = create, `PUT`/`PATCH` = update, `DELETE` = remove), path (`/hello`), headers (metadata), body (data payload — mostly absent on GET).
- **Response:** status code (`2xx` success, `4xx` client error e.g. `404`, `5xx` server error), headers, body.
- `@GetMapping("/path")` filters on **both** path and HTTP method — a `POST` to a `@GetMapping`-only path returns `405`, not a match.

## JSON

- Text format for structured data: key-value pairs — strings, numbers, booleans, nested objects, arrays.

```json
  { "name": "Eren", "balance": 500.0, "isActive": true }
```

- Language-agnostic, not Java-specific.
- Spring auto-converts a returned Java object into JSON (via the Jackson library) once `spring-boot-starter-webmvc` is on the classpath — no manual conversion code needed.












## 1. Spring Boot — first REST endpoint
 - Set up via Spring Initializr (Maven, Spring Boot 4.1.1, spring-boot-starter-webmvc — renamed from -web in Boot 4.x). 
 - Built @RestController + @GetMapping("/hello") returning a String.
 - Annotations = metadata Spring scans at startup to wire routing automatically, not executed code (same idea as @Override, different reader). 
 - Env issues hit & fixed: Maven Central 403'd due to a regional Cloudflare block (fixed via VPN); IntelliJ ignored pom.xml's Java version (fixed via "Delegate IDE build/run actions to Maven"); port 8080 conflicts from orphaned java.exe after using exec:exec (switched to spring-boot:run, which manages process lifecycle correctly). 

## 2. Query params require explicit @RequestParam — mostly
 - `@PathVariable` maps a {placeholder} in the URL path directly to a method parameter.
 - `@RequestParam` maps a query string param (?a=5&b=6) to a parameter 
 - annotate every param individually, don't rely on Spring's implicit fallback (it works for simple types like int/String when compiler -parameters flag is on, but it's fragile and non-obvious — always be explicit).


## 3. Returning JSON objects (not just Strings)
 - Jackson needs public getters (or public fields) to serialize a class — package-private fields with no getters silently produce empty/broken JSON. 
 - Getter naming convention (getX()) is what Jackson uses via reflection to build key names — same "framework reads convention automatically" pattern as annotations. 
 - JSON key order is not guaranteed and not meaningful — don't rely on it; consuming code reads by key name, not position.

