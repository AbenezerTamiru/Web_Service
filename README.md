# Assignment 1 - Part 3: SOAP-based Web Services

## 1. Introduction

Implemented a SOAP web service using Java and JAX-WS that provides calculator functionality with add and subtract operations.

## 2. Implementation

### Service Interface (`Calculator.java`)

```java
@WebService(name = "Calculator", targetNamespace = "http://calculator.example.com/")
public interface Calculator {
    @WebMethod double add(@WebParam(name = "a") double a, @WebParam(name = "b") double b);
    @WebMethod double subtract(@WebParam(name = "a") double a, @WebParam(name = "b") double b);
}
```

### Service Implementation (`CalculatorServiceImpl.java`)

```java
@WebService(endpointInterface = "com.example.calculator.Calculator")
public class CalculatorServiceImpl implements Calculator {
    @Override
    public double add(double a, double b) {
        System.out.println("Adding: " + a + " + " + b + " = " + (a + b));
        return a + b;
    }
    @Override
    public double subtract(double a, double b) {
        System.out.println("Subtracting: " + a + " - " + b + " = " + (a - b));
        return a - b;
    }
}
```

## 3. Testing with Thunder Client

### Request

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:calc="http://calculator.example.com/">
   <soapenv:Body>
      <calc:add>
         <a>15.5</a>
         <b>4.5</b>
      </calc:add>
   </soapenv:Body>
</soapenv:Envelope>
```

### Response

```xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:addResponse xmlns:ns2="http://calculator.example.com/">
            <return>20.0</return>
        </ns2:addResponse>
    </S:Body>
</S:Envelope>
```
## Screenshots

###  Server running successfully
![Server running successfully](https://github.com/mengistu3137/Web_Service/blob/soap-based-web-services/screenshots/Screenshot%202025-10-24%20002201.jpg)

### Tested successfully
![Tested successfully](https://github.com/mengistu3137/Web_Service/blob/soap-based-web-services/screenshots/Screenshot%202025-10-24%20004030.jpg)

###  Console log
![Additional test](https://github.com/mengistu3137/Web_Service/blob/soap-based-web-services/screenshots/Screenshot%202025-10-24%20004407.jpg)



## 4. Results

- ✅ **Service Status:** Running successfully on `http://localhost:8080/calculator`
- ✅ **WSDL:** Available at `http://localhost:8080/calculator?wsdl`
- ✅ **Add Operation:** 15.5 + 4.5 = 20.0 ✓
- ✅ **Response Time:** 194ms
- ✅ **SOAP Compliance:** Proper XML formatting and namespace handling

## 5. Tools Used

- **Java 17** with JAX-WS
- **IntelliJ IDEA** for development
- **Maven** for dependency management
- **Thunder Client** for testing

## 6. Conclusion

Successfully created and tested a functional SOAP web service that handles arithmetic operations with proper XML/SOAP protocol compliance. The service demonstrates understanding of JAX-WS annotations, namespace management, and SOAP message structure.

-
