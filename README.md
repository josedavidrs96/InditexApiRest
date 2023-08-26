# InditexApiRest

This is an application that provides a REST API to query price information at Inditex.

## Execution Instructions

Follow these steps to compile and run the application:

1. **Compile the Code**

   Open a terminal in the project's root directory and execute the following command to compile the code:


2. **Run the Application**

Once the compilation completes successfully, run the main class `ApiRestApplication` to start the application:


3. **Access Swagger to Query the API**

Open your web browser and navigate to [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) to view the API documentation in Swagger. Here, you can make requests and test the various API endpoints.

Alternatively, you can use Postman to make requests. You can download Postman from [this link](https://www.postman.com/downloads/).

4. ***Using Docker (Optional)***

If you prefer to run the application in a Docker container, ensure you have Docker installed on your system. You can download Docker from [this link](https://www.docker.com/get-started/).

To build and run the application using Docker, execute the following commands in the project's root directory:

*Build the Docker image with this command*
```bash
docker build -t inditex-api-rest .
```

# Run the Docker container
```bash
docker run -p 8080:8080 inditex-api-rest
```


## Available Endpoints

Below are some of the available endpoints in the API:

- **Calculate Price Endpoint**

Allows you to calculate the price based on specific parameters.

- Method: GET
- Path: `/api/priceInfo/calculatePrice`
- Parameters:
- `applicationDate`: Application date (Example: "2023-08-25 10:00:00")
- `productId`: Product ID (Integer)
- `brandId`: Brand ID (Integer)

Example URL: `http://localhost:8080/api/priceInfo/calculatePrice?applicationDate=2023-08-25T10:00:00&productId=123&brandId=1`

## Notes

- Ensure you have Java and Maven installed on your system.
- If you encounter any issues, verify that the necessary ports are available and there are no conflicts.
- If you want to perform tests using Postman, make sure to import the provided collection of requests and environment from the project.

