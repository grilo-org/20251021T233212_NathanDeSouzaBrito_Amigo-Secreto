
# Secret Friend 🎁

Projeto fullstack para sorteio de amigo secreto.

## Tecnologias
- Backend: Java + Spring Boot
- Frontend: Vue + Vite
- Banco de Dados: MongoDB
- Build: Maven


## Requisitos
- Java 21+
- Maven 3.9+
- Node 18+ e npm
- MongoDB em localhost: 27017
- Conta SMTP de testes (Ethereal)

##  Clonar o repositório
git clone https://github.com/NathanDeSouzaBrito/Amigo-Secreto


## Como rodar o backend
mvnw spring-boot:run
<br/>

Backend disponível em:
http://localhost:8080
<br/>

## Como rodar o frontend
cd frontEnd
npm install
npm run dev
<br/>

Frontend disponível em:
http://localhost:5173
<br/>

## Endpoints principais
POST /api/persons      -> adiciona pessoa <br/>
GET  /api/persons      -> lista pessoas <br/>
PUT  /api/persons/{id} -> atualiza pessoa <br/>
DELETE /api/persons/{id} -> remove pessoa <br/>
POST /api/persons/draw -> realiza o sorteio e envia e-mails <br/>
