Feature: Token

  @Token
  Scenario: Como usuario administrador obtener y borrar un token

    Given tengo acceso a todoly

    When mando una GET request al url http://todo.ly/api/authentication/token.json
    And obtengo una propiedad TokenString y la guardo en TokenValue
    Then espero un response body
    """
    {
      "TokenString": TokenValue,
      "UserEmail": "abc@ubp.edu",
      "ExpirationTime": "IGNORE"
    }
    """

    When mando una solicitud de delete al url http://todo.ly/api/authentication/token.json
    Then espero un response body
    """
    {
      "TokenString": TokenValue,
      "UserEmail": "abc@ubp.edu",
      "ExpirationTime": "IGNORE"
    }
    """