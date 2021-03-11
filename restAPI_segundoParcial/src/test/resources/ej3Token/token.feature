Feature: Token

  @Token
  Scenario: Como administrador quiero obtener un token y luego borrar el token
    Given yo tengo acceso al todoly
    When envio una Get request al url https://todo.ly/api/authentication/token.json
    And obtengo una propiedad TokenString y la guardo en TokenValue
    Then espero un cuerpo de respuesta
    """
{
    "TokenString":TokenValue,
    "UserEmail":"QA2p@upb.com"
    "ExpirationTime":"IGNORE"
}

    """
    When mando una request de Delete al url https://todo.ly/api/authentication/token.json
    Then yo espero el response body sea
    """
    {
    "TokenString":TokenValue
    "UserEmail":"QA2p@upb.com"
    "ExpirationTime":"IGNORE"

    }
    """