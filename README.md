# AINotes
Ai notes is a Java Spring rest api which also acts as a client to an OpenAi api.
It is intended to be used as backend for a service that requires OpenAI integration and storage for AI responses in a connected database.
It is secured with JWT. 

## Setup

Project is hosted on AWS so if you want to test it out, here is a simple documentation.

### Authentication:

Register:
```
POST http://ec2-3-71-35-162.eu-central-1.compute.amazonaws.com:8080/authenticate/register
request body:
{ "username":
  "password":
}
```
Login:
```
POST http://ec2-3-71-35-162.eu-central-1.compute.amazonaws.com:8080/authenticate/login
request body:
{ "username":
  "password":
}
response: Jwt Token
```
AI communication:
```
POST http://ec2-3-71-35-162.eu-central-1.compute.amazonaws.com:8080/gpt/completion
authorization:
    Bearer Token: Jwt Token you received in login response.

request body:
   your prompt for gpt. example: write me a note about city of Warsaw.
response:
   Unfiltered whole response from OpenAI Gpt api.

```

```
POST http://ec2-3-71-35-162.eu-central-1.compute.amazonaws.com:8080/gpt/completionOnlyResponse
authorization:
    Bearer Token: Jwt Token you received in login response.

request body:
   your prompt for gpt. example: write me a note about city of Warsaw.
response:
   text response from OpenAI Gpt api.

```

