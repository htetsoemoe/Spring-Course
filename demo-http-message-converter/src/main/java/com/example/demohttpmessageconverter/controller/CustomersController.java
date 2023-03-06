package com.example.demohttpmessageconverter.controller;

import com.example.demohttpmessageconverter.dao.CustomersDao;
import com.example.demohttpmessageconverter.ds.Customer;
import com.example.demohttpmessageconverter.ds.Customers;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Content;
import com.rometools.rome.feed.rss.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class CustomersController {

    @Autowired
    private CustomersDao customersDao;

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Customer> listCustomersJSON() {
        return customersDao.findAll();
    }

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_XML_VALUE)
    public Customers listCustomersXML() {
        return new Customers(customersDao.findAll());
    }

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_RSS_XML_VALUE)
    public Channel listCustomersRSS() throws MalformedURLException {
        Channel channel = new Channel();
        channel.setFeedType("rss_2.0");
        channel.setTitle("Customers RSS");
        channel.setDescription("Example RSS Feed in Spring Boot");
        channel.setLink(
                ServletUriComponentsBuilder.fromCurrentRequest().build()
                        .toUri().toURL().toExternalForm()
        );

        List<Item> customersRssItems = StreamSupport.stream(customersDao.findAll().spliterator(), false)
                .map(this::customerAsRssItem)
                .collect(Collectors.toList());
        channel.setItems(customersRssItems);
        return channel;

    }

    @PostMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Customer createCustomerJSON(@RequestBody Customer customer) {
        return customersDao.save(customer);
    }

    @PostMapping(value = "/customers", consumes = MediaType.APPLICATION_XML_VALUE)
    public Customer createCustomerXML(@RequestBody Customer customer) {
        return customersDao.save(customer);
    }


    // Helper method for listCustomersRSS()
    private Item customerAsRssItem(Customer customer) {
        Item item = new Item();
        Content content = new Content();
        content.setType(Content.TEXT);
        content.setValue(customer.toString());
        item.setContent(content);
        return item;
    }
}
