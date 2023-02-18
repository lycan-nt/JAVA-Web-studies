FROM node:10-slim
WORKDIR /home/node/app
COPY /api/* ./
RUN npm install
RUN npm install mysql2
CMD npm start