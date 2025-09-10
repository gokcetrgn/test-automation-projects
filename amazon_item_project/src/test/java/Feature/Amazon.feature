Feature: Amazon

  Scenario:
    Given Amazon.com açılır
    When Cookie kabul edilir
    When Aramaya urun yazılır ve aranır
    When Ürün sadece Amazon Tarafından gönderilir.
    When Marka Apple seçilir
    When İlk ürün seçilir
    When Sepete eklenir
    Then Ürünün sepete geldiği kontrol edilir