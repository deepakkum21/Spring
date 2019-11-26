# Objective

1. Create a new authentication API endpoint.
2. Examine every incoming request for valid JWT and authorize.

## Step1. Create a /authenticate API endpoint
	- Accepts user ID and password
	- Returns JWT as response
	

## Step2. Intercept all incoming request
	- Extract jwt from the header
	- Validate and set in the execution context